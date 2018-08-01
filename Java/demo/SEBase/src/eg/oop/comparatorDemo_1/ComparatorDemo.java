/*
 *  compare��a,b������:���ݵ�һ������С�ڡ����ڻ���ڵڶ��������ֱ𷵻ظ������������������
 *  equals��obj������������ָ���Ķ���Ҳ��һ�� Comparator������ǿ��ʵʩ��� Comparator ��ͬ������ʱ�ŷ��� true��
 *  Collections.sort(list, new PriceComparator());�ĵڶ�����������һ��int�͵�ֵ�����൱��һ����־������sort������ʲô˳������list��������
 */

package eg.oop.comparatorDemo_1;

import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.GregorianCalendar;  
import java.util.Iterator;  
import java.util.List; 

public class ComparatorDemo {
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {  
        List<Book> list = new ArrayList<Book>(); // ��������  
        Book b1 = new Book(10000, "��¥��", 150.86, new GregorianCalendar(2009,  
                01, 25), "��ѩ�ۡ��߶�");  
        Book b2 = new Book(10001, "��������", 99.68, new GregorianCalendar(2008, 7,  
                8), "�޹��� ");  
        Book b3 = new Book(10002, "ˮ䰴�", 100.8, new GregorianCalendar(2009, 6,  
                28), "ʩ���� ");  
        Book b4 = new Book(10003, "���μ�", 120.8, new GregorianCalendar(2011, 6,  
                8), "��ж�");  
        Book b5 = new Book(10004, "�����˲�", 10.4, new GregorianCalendar(2011, 9,  
                23), "�Ѻ�");  
        list.add(b1);  
        list.add(b2);  
        list.add(b3);  
        list.add(b4);  
        list.add(b5);  
        // Collections.sort(list); //û��Ĭ�ϱȽ�������������  
        System.out.println("���������е�Ԫ��:");  
        myprint(list);  
        Collections.sort(list, new PriceComparator()); // ���ݼ۸�����  
        System.out.println("����ļ۸�����:");  
        myprint(list);  
        Collections.sort(list, new CalendarComparator()); // ����ʱ������  
        System.out.println("����ĳ���ʱ������:");  
        myprint(list);  
    }  
  
    // �Զ��巽�������д�ӡ���list�е�Ԫ��  
    @SuppressWarnings("rawtypes")
	public static void myprint(List<Book> list) {  
        Iterator it = list.iterator(); // �õ������������ڱ���list�е�����Ԫ��  
        while (it.hasNext()) {// �������������Ԫ�أ��򷵻�true  
            System.out.println("\t" + it.next());// ��ʾ��Ԫ��  
        }  
    }  
  
    // �Զ���Ƚ���������ļ۸�����  
    @SuppressWarnings("rawtypes")
	static class PriceComparator implements Comparator {  
        public int compare(Object object1, Object object2) {// ʵ�ֽӿ��еķ���  
            Book p1 = (Book) object1; // ǿ��ת��  
            Book p2 = (Book) object2;  
            return new Double(p1.price).compareTo(new Double(p2.price));  
        }  
    }  
  
    // �Զ���Ƚ������������ʱ��������  
    @SuppressWarnings("rawtypes")
	static class CalendarComparator implements Comparator {  
        public int compare(Object object1, Object object2) {// ʵ�ֽӿ��еķ���  
            Book p1 = (Book) object1; // ǿ��ת��  
            Book p2 = (Book) object2;  
            return p2.calendar.compareTo(p1.calendar);  
        }  
    } 
}