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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Event implements Serializable {
	private static final long serialVersionUID = 1L;
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
	@Override
	public String toString() {
		SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "[제목]" + title + "\n[기간]" + d.format(startTime) + "~" + d.format(lastTime) + "\n[상세]" + details;
	}
}
public class Event1 {
	public static String name;
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException{
		Scanner scan = new Scanner(System.in);
		 System.out.print("사용자 아이디를 입력하세요 >> ");
		name = scan.nextLine();
		Map<String, List<Event>> events = loadEvents();
		while(true) {
			System.out.print("메뉴번호를 입력하세요(1. 종료, 2. 달력조회, 3. 이벤트추가, 4. 이벤트 조회, 5. 이벤트 변경, 6. 이벤트 삭제) >> ");
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

//======================================================================================================================================
	
	private static void saveEvents(Map<String, List<Event>> events) throws IOException {
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(name+".ser"));
		writer.writeObject(events);
		writer.flush();
		writer.close();
	}
	
//======================================================================================================================================
	
	private static void printEvent(Map<String, List<Event>> events) {
	    try {
		Scanner scan = new Scanner(System.in);
	    System.out.print("조회할 년도를 입력하세요>>");
	    int year = scan.nextInt(); 
	    System.out.print("조회할 월을 입력하세요>>");
	    int month = scan.nextInt(); 
	    scan.nextLine(); 
	    Calendar ca1 = Calendar.getInstance();
	    ca1.set(year, month-1,1);  
	    int firstweek = ca1.get(Calendar.DAY_OF_WEEK);  
	    int lastday = ca1.getActualMaximum(Calendar.DATE); 
	    System.out.println("\t" + year + "년 " + month + "월");
	    System.out.printf("%-3c %-4c %-4c %-3c %-4c %-4c %-3c", '일', '월', '화', '수', '목', '금', '토'); 
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
	            System.out.printf("%5s"," "); 
	        } else {
	            int count = eventCount.getOrDefault(day, 0);
	            if (count > 0) {
	            	System.out.printf("%-2d(%d)", day, count);
	            } else {
	                System.out.printf("%-4d ", day);
	            }
	            day++; 
	        }
	        if (i % 7 == 0) System.out.println();
	    }
	    System.out.println();
	    }catch (Exception e) {
	    	System.out.println("잘못된 형식입니다.");
	    }
	}
	
//======================================================================================================================================
	
	private static void addEvent(Map<String, List<Event>> events) {
	    Scanner scan = new Scanner(System.in);
	    Date date = null;
	    while (date == null) {
	        System.out.print("년도와 날짜를 입력하세요 >> (yyyy-MM-dd) ");
	        date = parseDate(scan.nextLine(), "yyyy-MM-dd");
	    }
	    System.out.print("이벤트 제목을 입력하세요 >> ");
	    String title = scan.nextLine();
	    Date startTime = null;
	    while (startTime == null) {
	        System.out.print("이벤트 시작 시간을 입력하세요 >> (yyyy-MM-dd HH:mm:ss) ");
	        startTime = parseDate(scan.nextLine(), "yyyy-MM-dd HH:mm:ss");
	    }
	    Date endTime = null;
	    while (endTime == null) {
	        System.out.print("이벤트 종료 시간을 입력하세요 >> (yyyy-MM-HH:mm:ss) ");
	        endTime = parseDate(scan.nextLine(), "yyyy-MM-dd HH:mm:ss");
	    }
	    System.out.print("이벤트 상세 정보를 입력하세요: ");
	    String details = scan.nextLine();
	    Event event = new Event(date, title, startTime, endTime, details);
	    List<Event> list = events.get(name);
	    if (list == null) {
	        list = new ArrayList<>();
	        events.put(name, list);
	    }
	    list.add(event);
	    System.out.println("이벤트가 추가되었습니다.");
	}
	
//====================================================================================================================================	
	private static Date parseDate(String dateString, String pattern) {
	    try {
	        SimpleDateFormat format = new SimpleDateFormat(pattern);
	        return format.parse(dateString);
	    } catch (ParseException e) {
	        System.out.println("잘못된 날짜/시간 형식입니다. 다시 입력해주세요.");
	        return null;
	    }
	}
	
//======================================================================================================================================
	
	private static void viewEvent(Map<String, List<Event>> events) throws ParseException {
	    Scanner scan = new Scanner(System.in);
	   try { 
		   	System.out.print("조회할 날짜를 입력하세요 >> (yyyy-MM-dd) ");
	    	String date = scan.nextLine();
	    	Date date2 = format.parse(date);
	    	List<Event> list = events.get(name);
	    	if (list == null || list.isEmpty()) {
	        	System.out.println("저장된 이벤트가 없습니다.");
	        	return;
	    	}
	    	Collections.sort(list, (e1, e2) -> e1.startTime.compareTo(e2.startTime));
	    	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   
	    	for (int i = 0; i < list.size(); i++) {
	        	Event e = list.get(i);
	        	if (e.date.equals(date2)) {
	            	System.out.println("[제목] : " + e.title);
	            	System.out.println("[기간] : " + dateTimeFormat.format(e.startTime)+"~"+ dateTimeFormat.format(e.lastTime));
	            	System.out.println("[상세] : " + e.details);
	            	
	        	}
	    	}
	    }catch(Exception e) {
	    	System.out.println("형식에 맞게 입력하세요");
	    }
	}
	
//======================================================================================================================================	
	
	private static void changeEvent(Map<String, List<Event>> events) throws ParseException {
	    Scanner scan = new Scanner(System.in);
	    try {
	        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.print("수정할 이벤트의 날짜를 입력하세요 >> (yyyy-MM-dd) ");
	        String dateStr = scan.nextLine();
	        Date date2 = format.parse(dateStr);  
	        List<Event> list = events.get(name); 
	        if (list != null) {
	            boolean eventFound = false;
	            for (Event e : list) {
	                if (e.date.equals(date2)) {
	                    int count = 0;
	                    for (Event e1 : list) {
	                        if (e1.date.equals(date2)) {
	                            System.out.println("번호 " + (count + 1) + " => " + e1.toString());
	                            count++;
	                        }
	                    }
	                    System.out.println("수정할 이벤트 번호를 선택하세요: ");
	                    int choice = scan.nextInt();
	                    scan.nextLine();  
	                    if (choice < 1 || choice > count) {
	                        System.out.println("잘못된 번호입니다.");
	                        return;
	                    }
	                    Event s = list.get(choice - 1);
	                    System.out.println(s.toString());
	                    System.out.print("변경할 이벤트가 맞습니까? 변경하실려면 Y를 입력하세요: ");
	                    String input = scan.nextLine();
	                    if (input.equalsIgnoreCase("y")) {
	                        Event e2 = list.get(choice - 1); 
	                        System.out.println(e2.toString());
	                        System.out.print("새로운 제목을 입력하세요: ");
	                        e2.title = scan.nextLine();  
	                        System.out.print("새로운 시작 시간을 입력하세요 (yyyy-MM-dd HH:mm:ss): ");
	                        String newStartTime = scan.nextLine();
	                        e2.startTime = a.parse(newStartTime); 
	                        System.out.print("새로운 종료 시간을 입력하세요 (yyyy-MM-dd HH:mm:ss): ");
	                        String newEndTime = scan.nextLine();
	                        e2.lastTime= a.parse(newEndTime);  
	                        System.out.print("새로운 상세 정보를 입력하세요: ");
	                        e2.details = scan.nextLine();  
	                        System.out.println("이벤트가 변경되었습니다.");
	                        eventFound = true;
	                    } else {
	                        System.out.println("변경이 취소되었습니다.");
	                        return;
	                    }
	                }
	            }
	            if (!eventFound) {
	                System.out.println("해당 날짜에 이벤트가 없습니다.");
	            }
	        } else {
	            System.out.println("이벤트 리스트가 비어 있습니다.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("숫자 형식에 맞게 입력하세요.");
	    } catch (ParseException e) {
	        System.out.println("날짜 형식에 맞게 입력하세요.");
	    } catch (IllegalArgumentException e) {
	        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
	    } catch (Exception e) {
	        System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
	    }
	}

//======================================================================================================================================	

	private static void deleteEvent(Map<String, List<Event>> events) throws ParseException {
	    Scanner scan = new Scanner(System.in);
	    try {
	        System.out.print("삭제할 이벤트의 날짜를 입력하세요 >> (yyyy-MM-dd) ");
	        String date = scan.nextLine();
	        Date date2 = format.parse(date);

	        List<Event> list = events.get(name);
	        if (list == null || list.isEmpty()) {
	            System.out.println("저장된 이벤트가 없습니다.");
	            return;
	        }

	        List<Event> s = new ArrayList<>();
	        for (Event e : list) {
	            if (e.date.equals(date2)) {
	                s.add(e);
	            }
	        }

	        if (s.isEmpty()) {
	            System.out.println("해당 날짜에 이벤트가 없습니다.");
	            return;
	        }

	        Collections.sort(s, (e1, e2) -> e1.startTime.compareTo(e2.startTime));
	        System.out.println("해당 날짜에 등록된 이벤트 목록:");
	        for (int i = 0; i < s.size(); i++) {
	            Event e = s.get(i);
	            System.out.println("번호: " + (i + 1) + " => " + e.toString());
	        }

	        System.out.print("삭제할 이벤트 번호를 입력하세요 >> ");
	        int choice = scan.nextInt();
	        scan.nextLine();  

	        if (choice < 1 || choice > s.size()) {
	            System.out.println("잘못된 번호입니다.");
	            return;
	        }

	        Event s1 = s.get(choice - 1);
	        System.out.println(s1.toString());

	        System.out.print("삭제할 이벤트가 맞습니까? 삭제하려면 Y를 입력하세요: ");
	        String input = scan.nextLine();

	        if (input.equalsIgnoreCase("y")) {
	        	System.out.println(s1.toString()+"=>내용삭제 완료");
	            list.remove(s1);
	            System.out.println("이벤트가 삭제되었습니다.");
	        } else {
	            System.out.println("삭제가 취소되었습니다.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("숫자 형식에 맞게 입력하세요.");
	    } catch (ParseException e) {
	        System.out.println("날짜 형식에 맞게 입력하세요.");
	    } catch (IllegalArgumentException e) {
	        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
	    } catch (Exception e) {
	        System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
	    }
	}


//======================================================================================================================================	

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