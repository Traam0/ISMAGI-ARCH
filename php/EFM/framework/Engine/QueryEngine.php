<?php

namespace Isla\Framework\Engine;

use Exception;
use Throwable;

class QueryEngine
{

    private array $context;
    private array $rows;
    private array $errors;

    public function __construct(array $context)
    {
        $this->context = $context;
        $this->rows = [];
        $this->errors = [];
    }


    public function Evaluate(string $query): mixed
    {
        $rows = [];
        $original = $query;
        $query = $this->ParseDirectives(trim($query));
        ob_start();
        eval('?>' . $query);
        // dd($original, $query, $rows, $this->context);
        return $rows;
    }


    protected static function Sanitize($expression): string
    {
        return htmlspecialchars($expression, ENT_QUOTES, 'UTF-8');
    }


    protected static function ParseDirectives(string $expression): string
    {
        $original = $expression;
        $directives = [
            '/where\s*\(\s*(\w+)\s*([=!><]+)\s*([\d\w_\-\'\"]+)\s*\)\s*(?:select\((\d+|all)\))/' => file_get_contents(__DIR__ . "/blueprints/select.blueprint.txt"),
            '/insert\s*\(([\w\s,]+)\s*\)\s*as\s*\(\s*([^\'\\<>]+)\s*\)/' => file_get_contents(__DIR__ . "/blueprints/insert.blueprint.txt")
        ];
        // $query->Evaluate("insert (id, username, email, password) as (auto, $username, $email, $password)");
        foreach ($directives as $directive => $raw) {
            $expression = preg_replace($directive, $raw, $expression);
        }
        if ($expression == $original) throw new Exception("Invalid Query");
        return $expression;
    }
}
