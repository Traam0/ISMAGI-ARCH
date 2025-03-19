<?php

namespace Isla\Framework\Http;

class Response
{
    private readonly ?string $content;
    private int $status;
    private array $headers ; 

    function __construct(?string $content = null, int $status = 200, array $headers = [])
    {
        $this->content = $content;
        $this->status = $status;
        $this->headers = $headers;
    }

    public function Send(): void
    {
        http_response_code($this->status);
        foreach ($this->headers as $header) header($header);
        echo $this->content;
    }

    public static function Redirect(string $url, int $statusCode = 302): self
    {
        return new self(status: $statusCode, headers: ["Location: $url"]);
    }
}