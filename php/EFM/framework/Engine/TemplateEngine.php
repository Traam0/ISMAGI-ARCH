<?php

namespace Isla\Framework\Engine;

use Exception;


class TemplateEngine
{


    public static function Render(string $viewName, array $templateData = ["formValues" => null, "errors" => null]): string
    {
        $templatePath  = APP_ROOT . "/views/" . str_replace(".", "/", $viewName) . ".template.html";
        if (!file_exists($templatePath)) {
            dd("Template not found: $viewName");
        }
        extract($templateData);

        //        dd($content);
        $content = self::ParseDirectives(self::Sanitize(file_get_contents($templatePath)));
        ob_start();
        eval('?>' . $content);
        return ob_get_clean();
    }

    public static function Sanitize(string $content): string
    {
        return preg_replace_callback('/<\?(php|=)(.*?)\?>/s', function ($matches) {
            return htmlspecialchars($matches[0], ENT_QUOTES, 'UTF-8');
        }, $content);
    }

    protected static function ParseDirectives($content): string
    {
        $directives = [
            '/@if\((.*?)\)/' => '<?php if ($1): ?>',
            '/@elseif\((.*?)\)/' => '<?php elseif ($1): ?>',
            '/@else/' => '<?php else: ?>',
            '/@endif/' => '<?php endif; ?>',
            '/@foreach\((.*?)\)/' => '<?php foreach ($1): ?>',
            '/@endforeach/' => '<?php endforeach; ?>',
            '/@put\((.*?)\)/' => '<?= htmlspecialchars($1, ENT_QUOTES, \'UTF-8\') ?>',
            '/@css\((.*?)\)/' => '<link rel="stylesheet" href="/styles/$1.css">',
            '/@script\((.*?)\)/' => '<script src="/scripts/$1.js"></script>',
            '/@script_d\((.*?)\)/' => '<script src="/scripts/$1.js" defer></script>',
        ];

        foreach ($directives as $directive => $raw) {
            $content = preg_replace($directive, $raw, $content);
        }

        return $content;
    }
}
