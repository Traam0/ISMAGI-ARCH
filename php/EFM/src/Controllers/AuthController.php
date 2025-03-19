<?php

namespace App\Controllers;

use App\DataBase\DAL;
use App\Abstractions\ControllerBase;
use Isla\Framework\Engine\QueryEngine;
use Isla\Framework\Engine\TemplateEngine;
use Isla\Framework\Http\Request;
use Isla\Framework\Http\Response;

class AuthController extends ControllerBase
{
    function __construct()
    {
        parent::__construct();
    }

    public function index(mixed $params, Request $request): Response
    {
        if ($request->session->Has("user")) return Response::Redirect("/");
        return new Response(TemplateEngine::Render("Auth.index", ["title" => "Login"]));
    }

    public function login(mixed $params, Request $request): Response
    {
        $validationResult = Request::ValidateRequest($request->postParams, [
            "username" => [
                "regex" => "/^[a-zA-Z0-9]+$/",
                "message" => "Invalid username",
            ],
            "password" => [
                "regex" => "/^[a-zA-Z0-9]+$/",
                "message" => "Invalid password",
            ],
        ]);

        if (is_array($validationResult)) return new Response(TemplateEngine::Render(
            "Auth.index",
            [
                "title" => "Login",
                "errors" => $validationResult,
                "formValues" => $request->postParams
            ]
        ));

        $username = $request->postParams["username"];
        $users = DAL::getUsers();
        $queryContext = new QueryEngine($users);

        $result = $queryContext->Evaluate("where(username == '$username') select(1)", $users);
        if (!isset($result)) return new Response(TemplateEngine::Render(
            "Auth.index",
            [
                "title" => "login | isla",
                "errors" => ["Invalid Username"],
                "formValues" => $request->postParams,
            ]
        ));

        if ($result["password"] != $request->postParams["password"]) return new Response(TemplateEngine::Render(
            "Auth.index",
            [
                "title" => "login | isla",
                "errors" => ["Invalid Username or Password"],
                "formValues" => $request->postParams,
            ]
        ));

        $request->session->Set("user", $result);
        return Response::Redirect("/");
    }


    public function registerPage(mixed $params, Request $request): Response
    {
        if ($request->session->Has("user")) return Response::Redirect("/");
        return new Response(TemplateEngine::Render("Auth.register", ["title" => "register | isla"]));
    }

    public function register(mixed $params, Request $request): Response
    {
        $result = Request::ValidateRequest($request->postParams, [
            "username" => [
                "regex" => "/^[a-zA-Z0-9]+$/",
                "message" => "Invalid username",
            ],
            "email" => [
                "regex" => "/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/",
                "message" => "Invalid email",
            ],
            "password" => [
                "regex" => "/^[a-zA-Z0-9]+$/",
                "message" => "Invalid password",
            ],
            "confirmPassword" => [
                "regex" => "/^[a-zA-Z0-9]+$/",
                "message" => "Invalid password"
            ],
        ]);


        if (is_array($result)) {
            if ($request->postParams["password"] != $request->postParams["confirmPassword"]) {

                $result[] = "Passwords do not match";
            }

            return new Response(TemplateEngine::Render("Auth.register", ["errors" => $result, "formValues" => $request->postParams]));
        }

        $queryContext = new QueryEngine(DAL::getUsers());
        $query = "where(username == '" . $request->postParams["username"] . "') select(1) ";
        $result = $queryContext->Evaluate($query);
        
        if (isset($result)) return new Response(TemplateEngine::Render(
            "Auth.register",
            [
                "title" => "register | bloglog",
                "errors" => ["username already exists"],
                "formValues" => $request->postParams,
            ]
        ));


















        

        $query = "insert (id, username, email, password) as (auto, " . $request->postParams['username'] . ", " . $request->postParams['email'] . ", " . $request->postParams['password'] . ")";
















        $result = $queryContext->Evaluate($query);
        if (!DAL::WriteTo("users", $result)) new Response(TemplateEngine::Render("_505", ["error" => "Failed to create user"]));
        return Response::Redirect("/");
    }

    public function logout(mixed $params, Request $request): Response
    {
        if ($request->session->Has("user")) {
            $request->session->Unset("user");
            return Response::Redirect("/");
        };

        return Response::Redirect($request->SanitizeRequestUri());
    }
}
