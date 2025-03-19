<?php

namespace Isla\Framework\Core;

class KernelBuilder
{
    private array $routes;

    public function __construct(){
        $this->routes = [];
    }

    public function MapGet(string $uri, mixed $handler): self
    {
        if(isset($this->routes["GET"]) === false) {
            $this->routes["GET"] = [];
        }
        $this->routes["GET"][$uri] = $handler;
        return  $this;
    }

    public function MapPost(string $uri, mixed $handler): self
    {
        if(isset($this->routes["POST"]) === false) {
            $this->routes["POST"] = [];
        }
        $this->routes["POST"][$uri] = $handler;
        return  $this;
    }

    public function Build(): Kernel
    {
        return new Kernel($this->routes["GET"] ?? [], $this->routes["POST"] ?? []);
    }
}