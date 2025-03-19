<?php

namespace App\DataBase;

use Isla\Framework\Engine\LinqEngine;

class IoDatabaseAdapter
{
    private static string $dataPath = __DIR__ . "/data";
    private array $tables;

    public function __construct()
    {
        if(!is_dir(self::$dataPath)) mkdir(self::$dataPath, 0777, true);
        $this->tables = [...array_filter(scandir(self::$dataPath), function ($item) {
            return  is_file(self::$dataPath . "/" . $item);
        })];
    }

    public function getTables(): array
    {
        return $this->tables;
    }


    public function GetTableRows(string $table): array
    {
        $handler = fopen(self::$dataPath . DIRECTORY_SEPARATOR . $table.".table", "r");
        $columns=  array_map('trim', explode("~", trim(fgets($handler))));
        $rows = [];
        while(($line = fgets($handler)) !== false) {
            $line = trim($line);
            if(empty($line)) continue;
            $values = array_map('trim', explode("~", $line));
            $rows[] = array_combine($columns, $values);
        }
        return $rows;
    }
}