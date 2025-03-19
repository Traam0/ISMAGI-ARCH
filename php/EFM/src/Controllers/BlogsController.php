<?php

namespace App\Controllers;

use App\Abstractions\ControllerBase;
use Isla\Framework\Engine\TemplateEngine;
use Isla\Framework\Http\Response;

class BlogsController extends ControllerBase
{
    public function __construct()
    {
        parent::__construct();
    }

    public function index(): Response
    {
        return new Response(TemplateEngine::Render('blogs.index'));
    }
}