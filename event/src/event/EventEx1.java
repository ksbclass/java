package event;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Event implements Serializable {
	String title;
	Date startTime;
	Date lastTime;
	String details;
	Date date;

	Event(Date date,String title, Date startTime,Date lastTime, String details) {
		this.title = title;
		this.startTime = startTime;
		this.details = details;
		this.lastTime = lastTime;
		this.date = date;
	}
}
public class EventEx1 {
	private static String name;
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException{

		Scanner scan = new Scanner(System.in);
		System.out.print("사용자 아이디를 입력하세요 : ");
		name = scan.nextLine();
		Map<String, List<Event>> events = loadEvents();
		//		List<Event> evList = new ArrayList<Event>();
		while(true) {
			System.out.print
			("메뉴번호를 입력하세요(1.종료, 2. 달력조회, 3.이벤트추가, 4.이벤트 조회, 5이벤트 변경, 6.이벤트 삭제)>>");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1 : saveEvents(events);System.out.println("프로그램을 종료합니다.");return;
			case 2 : printEvent(events);break;
			case 3 : addEvent(events);break;
			case 4 : viewEvent(events);break;
			case 5 : changeEvent(events);break;
			case 6 : deleteEvent(events);break;
			default:
				System.out.println("잘못된 입력입니다. 다시 선택하세요.");
			}
		}
	}
	private static void saveEvents(Map<String, List<Event>> events) throws IOException {
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(name+".ser"));
		writer.writeObject(events);
		writer.flush();
		writer.close();
	}

	private static void printEvent(Map<String, List<Event>> events) {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("조회할 년도를 입력하세요 : ");
	    int year = scan.nextInt(); 
	    System.out.print("조회할 월을 입력하세요: ");
	    int month = scan.nextInt(); 
	    scan.nextLine(); 
	    Calendar ca1 = Calendar.getInstance();
	    ca1.set(year, month - 1, 1);  
	    int firstweek = ca1.get(Calendar.DAY_OF_WEEK);  
	    int lastday = ca1.getActualMaximum(Calendar.DATE); 
	    System.out.println("\t" + year + "년 " + month + "월");
	    System.out.printf("%3c %3c %3c %3c %3c %3c %3c", '일', '월', '화', '수', '목', '금', '토'); 
	    System.out.println();
	    Map<Integer, Integer> eventCount = new HashMap<>();
	    List<Event> list = events.get(name); 
	    if (list != null) {
	        for (Event e : list) {
	            Calendar eventCal = Calendar.getInstance();
	            eventCal.setTime(e.date); 
	            if (eventCal.get(Calendar.YEAR) == year && eventCal.get(Calendar.MONTH) + 1 == month) {
	                int day = eventCal.get(Calendar.DAY_OF_MONTH);  
	                eventCount.put(day, eventCount.getOrDefault(day, 0) + 1); 
	            }
	        }
	    }
	    for (int i = 1, day = 1; day <= lastday; i++) {
	        if (i < firstweek) {
	            System.out.printf("%4s", " ");  
	        } else {
	            int count = eventCount.getOrDefault(day, 0);
	            if (count > 0) {
	            	System.out.printf("%2d(%d) ", day, count);
	            } else {
	                System.out.printf("%4d ", day);
	            }
	            day++; 
	        }
	        if (i % 7 == 0) System.out.println();
	    }
	    System.out.println();
	}
	
	private static void addEvent(Map<String, List<Event>> events) throws ParseException  {
	    Scanner scan = new Scanner(System.in);
	        System.out.print("년도와 날짜을 입력하세요 : (yyyy-MM-dd)");
	        String a = scan.nextLine();
            Date date = format.parse(a);
	        System.out.print("이벤트 제목을 입력하세요: ");
	        String title = scan.nextLine();
	        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.print("이벤트 시작 시간을 입력하세요: (yyyy-MM-dd hh:mm:ss)");
	        String b = scan.nextLine();
	        Date startTime = dateTimeFormat.parse(b);
	        System.out.print("이벤트 종료 시간을 입력하세요: (yyyy-MM-dd hh:mm:ss)");
	        String c = scan.nextLine();
	        Date endTime =dateTimeFormat.parse(c);
	        System.out.print("이벤트 상세 정보를 입력하세요: ");
	        String details = scan.nextLine();
	        Event event = new Event(date,title, startTime, endTime, details);
	        List<Event> list = events.get(name);
	        if (list == null) {
	            list = new ArrayList<Event>();
	            events.put(name, list);
	        }
	        list.add(event);
	        System.out.println("이벤트가 추가되었습니다.");
	}
	
	private static void viewEvent(Map<String, List<Event>> events) throws ParseException {
	    Scanner scan = new Scanner(System.in);
	    int count = 0;
	    System.out.print("조회할 날짜를 입력하세요 (yyyy-MM-dd): ");
	    String date = scan.nextLine();
	    Date date2 = format.parse(date);
	    List<Event> list = events.get(name);
	    if (list == null) {
	        System.out.println("저장된 이벤트가 없습니다.");
	        return;
	    }
	    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    for (Event e : list) {
	    	  Calendar calendar = Calendar.getInstance();
	          calendar.setTime(date2);
	          calendar.set(Calendar.HOUR_OF_DAY, 0);
	          calendar.set(Calendar.MINUTE, 0);
	          calendar.set(Calendar.SECOND, 0);
	          
	          if (e.date != null && e.date.equals(calendar.getTime())) {
	              System.out.println("이벤트 제목: " + e.title);
	              System.out.println("시작 시간: " + dateTimeFormat.format(e.startTime));
	              System.out.println("종료 시간: " + dateTimeFormat.format(e.lastTime));
	              System.out.println("상세 내용: " + e.details);
	              count++;
	          }
	    }
	    if (count == 0) {
	        System.out.println("해당 날짜에 이벤트가 없습니다.");
	    }
	}
	
	private static void changeEvent(Map<String, List<Event>> events)throws ParseException {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("수정할 이벤트의 날짜를 입력하세요 (yyyy-MM-dd): ");
	    String dateStr = scan.nextLine();
	    Date date2 = null;
	    date2 = format.parse(dateStr); 
	    List<Event> list = events.get(name);
	    if (list != null) {
	        boolean eventFound = false;
	        for (Event e : list) {
	            if (e.date.equals(date2)) {  
	                System.out.print("제목을 입력하세요: ");
	                e.title = scan.nextLine();
	                System.out.print("시작 시간을 입력하세요 (yyyy-MM-dd HH:mm): ");
	                String start = scan.nextLine();
	                System.out.print("종료 시간을 입력하세요 (yyyy-MM-dd HH:mm): ");
	                String end = scan.nextLine();
	                System.out.print("상세 정보를 입력하세요: ");
	                e.details = scan.nextLine();
	                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	                e.startTime = dateTimeFormat.parse(start);
	                e.lastTime = dateTimeFormat.parse(end);
	                System.out.println("이벤트가 변경되었습니다.");
	                return;
	            }
	        }
	        if (!eventFound) {
	            System.out.println("해당 날짜에 이벤트가 없습니다.");
	        }
	    } else {
	        System.out.println("이벤트 리스트가 비어 있습니다.");
	    }
	}


	private static void deleteEvent(Map<String, List<Event>> events) throws ParseException {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("삭제할 이벤트의 날짜를 입력하세요 (yyyy-MM-dd): ");
	    String date = scan.nextLine();
	    Date date2 = format.parse(date);
	    List<Event> list = events.get(name);
	    if (list != null) {
	        boolean eventFound = false;
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).date.equals(date2)) {
	                list.remove(i);
	                eventFound = true;
	                break;
	            }
	        }
	        if (eventFound) {
	            System.out.println("이벤트가 삭제되었습니다.");
	        } else {
	            System.out.println("해당 날짜에 이벤트가 없습니다.");
	        }
	    } else {
	        System.out.println("이벤트 리스트가 비어 있습니다.");
	    }
	}

	

	private static Map<String, List<Event>> loadEvents()throws IOException, ClassNotFoundException {
		File file = new File(name + ".ser");
		if (file.exists()) {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
			return (Map<String, List<Event>>)reader.readObject();
		}
		else {
			return new HashMap<String,List<Event>>();
		}
	}
}