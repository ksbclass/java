package event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Event {
    String title;
    String startTime;
    String details;
    Event(String title, String startTime, String details) {
        this.title = title;
        this.startTime = startTime;
        this.details = details;
    }
}
public class EventEx1  {
	private static String name;
	private static Map<String, Event> events = new HashMap<>();
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.print("사용자 아이디를 입력하세요 : ");
		name = scan.nextLine();
		loadEvents();
		while(true) {
			System.out.print
			("메뉴번호를 입력하세요(1.종료, 2. 달력조회, 3.이벤트추가, 4.이벤트 조회, 5이벤트 변경, 6.이벤트 삭제)");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1 : saveEvents();System.out.println("프로그램을 종료합니다.");return;
			case 2 : printEvent();break;
			case 3 : addEvent();break;
			case 4 : viewEvent();break;
			case 5 : changeEvent();break;
			case 6 : deleteEvent();break;
			default:
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
			}
		}
	}
	private static void saveEvents() throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(name + "_events.txt"));
		for (Map.Entry<String, Event> entry : events.entrySet()) {
			String date = entry.getKey();
			Event event = entry.getValue();
			writer.println(date + "#" + event.title + "#" + event.startTime + "#" + event.details);
		}
	}
	private static void changeEvent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이벤트의 날짜를 입력하세요 (yyyy-MM-dd): ");
        String date = scan.nextLine();

        Event event = events.get(date);
        if (event != null) {
            System.out.print("새로운 제목을 입력하세요: ");
            event.title = scan.nextLine();
            System.out.print("새로운 시작 시간을 입력하세요: ");
            event.startTime = scan.nextLine();
            System.out.print("새로운 상세 정보를 입력하세요: ");
            event.details = scan.nextLine();
            System.out.println("이벤트가 변경되었습니다.");
        } else {
            System.out.println("해당 날짜에 이벤트가 없습니다.");
        }
		
	}
	private static void deleteEvent() {
		Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 이벤트의 날짜를 입력하세요 (yyyy-MM-dd): ");
        String date = scan.nextLine();

        Event event = events.remove(date);
        if (event != null) {
            System.out.println("이벤트가 삭제되었습니다.");
        } else {
            System.out.println("해당 날짜에 이벤트가 없습니다.");
        }
    }
		
	private static void viewEvent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 날짜를 입력하세요 (yyyy-MM-dd): ");
        String date = scan.nextLine();

        Event event = events.get(date);
        if (event != null) {
            System.out.println("이벤트 제목: " + event.title);
            System.out.println("시작 시간: " + event.startTime);
            System.out.println("상세 내용: " + event.details);
        } else {
            System.out.println("해당 날짜에 이벤트가 없습니다.");
        }		
	}
	private static void addEvent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이벤트 제목을 입력하세요: ");
	    String title = scan.nextLine();
	    System.out.print("이벤트 시작 시간을 입력하세요: ");
	    String startTime = scan.nextLine();
	    System.out.print("이벤트 상세 정보를 입력하세요: ");
	    String details = scan.nextLine();
        System.out.print("이벤트 날짜를 입력하세요 (yyyy-MM-dd): ");
        String date = scan.nextLine();
        Event event = new Event(title, startTime, details);
        events.put(date, event);
        System.out.println("이벤트가 추가되었습니다.");	    
		
	}
	private static void printEvent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 년도를 입력하세요 : ");
		int year = scan.nextInt();
        System.out.print("조회할 월을 입력하세요: ");
        int month = scan.nextInt();
        scan.nextLine();
	}

	 private static void loadEvents()throws IOException {
		 File file = new File(name + "_events.txt");
		 if (file.exists()) {
			 BufferedReader reader = new BufferedReader(new FileReader(file)); 
	         String line;
	         while ((line = reader.readLine()) != null) {
	        	 String[] parts = line.split("#");
	             if (parts.length == 4) {
	            	 events.put(parts[0], new Event(parts[1], parts[2], parts[3]));
	            	 }
	             }
	         }
	 }
}