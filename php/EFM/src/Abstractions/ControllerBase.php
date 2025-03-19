<?php

namespace App\Abstractions;

use Isla\Framework\Http\Request;

class ControllerBase
{
    protected readonly Request $request;

    function __construct()
    {
        $this->request = Request::FromGlobals();
    }
}