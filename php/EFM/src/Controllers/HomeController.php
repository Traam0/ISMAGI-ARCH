<?php

namespace App\Controllers;

use App\Abstractions\ControllerBase;
use Isla\Framework\Engine\TemplateEngine;
use Isla\Framework\Http\Request;
use Isla\Framework\Http\Response;

class HomeController extends ControllerBase
{
    function __construct()
    {
        parent::__construct();
    }


    public function index($params, Request $request): Response{
        $view = TemplateEngine::Render("home", [
            "title" => "Home",
            'user' =>  $request->session->get('user')
        ]);

        return new Response($view);
    }

    public function about($params, Request $request): Response{

        return new Response("about Page" . $request->session->Get("__id"));
    }
}