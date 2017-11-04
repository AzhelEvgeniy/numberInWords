package dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    /*Const*/
    private final static char SEPARATOR = '=';
    /*Композиция*/
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
    }

    /*
    * Загружает файл и заполняет коллекцию Map значениями взятыми из файла.
    * @param path путь к загружаемому файлу
     */
    public void load(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.ready()){
                String line = reader.readLine();
                convertAndAddWordInDictionary(line);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String get(String key){
        return dictionary.get(key);
    }

    public Set<String> keySet(){
        return dictionary.keySet();
    }

    /*
    *Конвентирует строку из формата "key=value" в две отдельные строки
    * до и после разделителя.
    * Добавляет в коллекцию Map новый элемент.
    * @param line строка полученная из файла формата "key=value".
     */
    private void convertAndAddWordInDictionary(String line){
        String key = line.substring(0, line.indexOf(SEPARATOR));
        String value = line.substring(line.indexOf(SEPARATOR) + 1, line.length());
        dictionary.put(key, value);
    }

}
