package base.collection_framework_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		
		
		// Ű(Key)�� ��(Value)�� ������ Entry ��ü�� �����ϴ� ����
		
		// Ű�� �ߺ��� �� ������, ���� �ߺ� ����� �� ����
		// ������ ����� Ű�� ������ Ű�� ���� �����ϸ�, ���� ���� ���� ��������, ���ο� ������ ��ü
		
		
		// 1. HashMap
		
		// ��ǥ���� Map Collection
		// HashMap�� Ű�� ����� ��ü�� hashCode()�� equals()�� �������ؼ�, ���� ��ü�� �� ������ ���ؾ� ��
		
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("Jack", 30);
        map.put("Andy", 40);
        map.put("John", 22);
        map.put("Jolie", 10);
        map.put("Exo", 50);
        map.put("Tiger", 91);
        
        System.out.println("�� Entry ��: " + map.size());
        
        System.out.println("\tJolie" + map.get("Jolie"));
        System.out.println();
        
        // ��ü�� �ϳ��� ó��
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        
        while (it.hasNext()) {
            String key = it.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        
        System.out.println();
        
        // ��ü ����
        map.remove("Exo");
        System.out.println("�� Entry ��: " + map.size());
        
        map.clear();
        System.out.println("�� Entry ��: " + map.size());
        
        
        // 2. HashTable
        
        // HashTable�� Ű�� ����� ��ü�� hashCode()�� equals()�� �������ؼ�, ���� ��ü�� �� ������ ���ؾ� ��
        
        // HashMap���� ��������, HashTable�� ����ȭ(Synchronized)�� �Ǿ� �ִ�. ��Ƽ ������ ȯ�濡 ����
        
        
        // 3. Properties
        
        // HashTable�� ���� Ŭ����, HashTable�� ��� Ư¡�� �״�� ������ ����
        
        // �������� HashTable�� Ű�� ���� �پ��� Ÿ������ ���� �����ѵ� ����, Properties�� Ű�� ���� String���� ����
        
        // ������Ƽ(*.properties) ������ ���� �� �ַ� ���
        // ������Ƽ ������ Ű�� ���� = ��ȣ�� ����ܾ� �ִ� �ؽ�Ʈ ���Ϸ� ISO 8859-1 ���ڼ����� ����ȴ�
        
        Properties properties = new Properties();
        
        try {
			properties.load(new FileReader("C:/~/database.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
	}

}
