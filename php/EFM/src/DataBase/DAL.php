<?php

namespace App\DataBase;

use Exception;

class DAL
{
    private static string $dataPath = __DIR__ . "/data";

    public static function getUsers(): array
    {
        $tablePath = self::$dataPath . "/users.table.json";
        if (!file_exists($tablePath)) {
            touch($tablePath);
            file_put_contents($tablePath, "[]");
        }

        $rawJson = file_get_contents($tablePath);
        return json_decode($rawJson, true);
    }

    public static function WriteTo(string $table, array $data): bool
    {
        try {
            $dataEncoded = json_encode($data, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
            if (file_put_contents(self::$dataPath . "/$table.table.json", $dataEncoded)) return true;
            return false;
        } catch (Exception $ex) {
            return false;
        }
    }
}
