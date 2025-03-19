<?php

namespace Isla\Framework\Http;

class Session
{
    public function __construct()
    {
        if(session_status() == PHP_SESSION_NONE) session_start();
    }

    public function Set(string $key, mixed $value): void
    {
        $_SESSION[$key] = $value;
    }

    public function Unset(string $key): void
    {
        if($this->Has($key)) unset($_SESSION[$key]);
    }

    public function Get(string $key, mixed $default = null): mixed
    {
        if($this->Has($key)) return $_SESSION[$key];
        if($default !== null) $_SESSION[$key] = $default;
        return $default;
    }

    public function Has(string $key): bool
    {
        return isset($_SESSION[$key]);
    }

    public function All(): array
    {
        return $_SESSION;
    }

    public function Clear(): void
    {
        $_SESSION = [];
    }

    public function Regenerate(): void
    {
        session_regenerate_id(true);
    }

    public function Destroy(): void
    {
        $this->Clear();
        session_destroy();
    }

}