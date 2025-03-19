<?php

namespace Isla\Framework\Http;

class Request
{
    public readonly array $getParams;
    public readonly array $postParams;
    public readonly array $cookies;
    public readonly array $server;
    public readonly array $files;
    public ?Session $session;

    function __construct(array $getParams, array $postParams, array $cookies, array $files, array $server, ?Session $session = null)
    {
        $this->getParams = $getParams;
        $this->postParams = $postParams;
        $this->cookies = $cookies;
        $this->server = $server;
        $this->files = $files;
        $this->session = $session;
    }

    public static function FromGlobals(): static
    {
        return new static($_GET, $_POST, $_COOKIE, $_FILES, $_SERVER, new Session());
    }

    public function GetMethod(): string
    {
        return $this->server['REQUEST_METHOD'];
    }

    public function SanitizeRequestUri(): string
    {
        return strtok($this->server['REQUEST_URI'], '?');
    }

    public static function ValidateRequest(array $object, array $rules): bool | array
    {
        $errors = [];
        foreach ($rules as $property => $rule) {
            
            if (!isset($object[$property]) || trim($object[$property]) === '') {
                if (isset($rule['optional']) && $rule['optional']) {
                    continue;
                }
                $errors[] = "{$property} is required.";
                continue;
            }

            if (!preg_match($rule['regex'], $object[$property])) $errors[] = $rule['message'];
        }
        return empty($errors) ? true : $errors;
    }
}
