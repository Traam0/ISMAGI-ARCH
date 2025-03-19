<?php declare(strict_types=1);
define('APP_ROOT', dirname(__DIR__));
define("COLUMN_SEPERATOR", "~");
require dirname(__DIR__) . '/vendor/autoload.php';

use App\Controllers\AuthController;
use App\Controllers\BlogsController;
use App\Controllers\HomeController;
use Isla\Framework\Core\KernelBuilder;
use Isla\Framework\Engine\TemplateEngine;
use Isla\Framework\Http\Request;
use Isla\Framework\Http\Response;

$request = Request::fromGlobals();

$kernelBuilder = (new KernelBuilder())
    ->MapGet("/", [BlogsController::class, "index"])
    //
    ->MapGet("/blogs", [BlogsController::class, "index"])
    //
    ->MapGet("/login", [AuthController::class, "index"])
    ->MapPost("/login", [AuthController::class, "login"])
    ->MapGet("/register", [AuthController::class, "registerPage"])
    ->MapPost("/register", [AuthController::class, "Register"])
    ->MapGet("/logout", [AuthController::class, "logout"]);
//


$kernel = $kernelBuilder->build();
try {
    $response = $kernel->process($request);
    $response->Send();
} catch (\Exception $e) {
    $response = new Response(TemplateEngine::Render("_500", ["error" => $e->getMessage()]));
}