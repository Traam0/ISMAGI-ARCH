<?php

namespace Isla\Framework\Core;

use Exception;
use FastRoute\Dispatcher;
use FastRoute\RouteCollector;
use Isla\Framework\Engine\TemplateEngine;
use Isla\Framework\Http\Request;
use Isla\Framework\Http\Response;
use function FastRoute\simpleDispatcher;

class Kernel
{
    private Dispatcher $dispatcher;

    function __construct(array $getRoutes, array $postRoutes)
    {
        $this->dispatcher = simpleDispatcher(function (RouteCollector $collector) use ($getRoutes, $postRoutes) {
            foreach ($getRoutes as $path => $handler){
                $collector->get($path, $handler);
            }
            foreach ($postRoutes as $path => $handler){
                $collector->post($path, $handler);
            }
        });
    }

    /**
     * @throws Exception
     */
    public function process(Request $request): Response
    {

        [$status, $handler, $vars] = $this->dispatcher->dispatch($request->GetMethod(), $request->SanitizeRequestUri());
        switch ($status) {
            case Dispatcher::NOT_FOUND:
                return new Response(TemplateEngine::Render("_404"));
            case Dispatcher::METHOD_NOT_ALLOWED:
                throw  new Exception("method not allowed");
            case Dispatcher::FOUND:
                if(is_array($handler)){
                    $controller = $handler[0];
                    $method = $handler[1];
                    $instance = new $controller();
                    return call_user_func_array([$instance, $method], [$vars, $request]);
                }

                return $handler($vars);
            default:
                throw new Exception("");
        }

    }
}