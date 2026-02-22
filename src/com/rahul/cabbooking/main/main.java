package com.rahul.cabbooking.main;

import java.util.Scanner;

import com.rahul.cabbooking.dao.CabDAO;
import com.rahul.cabbooking.dao.DriverDAO;
import com.rahul.cabbooking.dao.UserDAO;
import com.rahul.cabbooking.model.Cab;
import com.rahul.cabbooking.model.Driver;
import com.rahul.cabbooking.model.User;
import com.rahul.cabbooking.service.BookingService;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();
        DriverDAO driverDAO = new DriverDAO();
        CabDAO cabDAO = new CabDAO();
        BookingService bookingService = new BookingService();

        while (true) {

            System.out.println("                                                                                         🌟 Rahul Cab Services                       \n \n \r\n"
            		
            		+ "Welcome to Rahul Cab Services, your trusted partner for safe, comfortable, and reliable travel.\n\r\n\n"
            		+ "We provide:\r\n"
            		+ "🚗 Well-maintained and clean vehicles\r\n"
            		+ "👨‍✈️ Experienced and professional drivers\r\n"
            		+ "🛣️ Smooth and safe journeys\r\n"
            		+ "⏱️ On-time pickup and drop\r\n"
            		+ "Your safety and comfort are our top priorities.\r\n"
            		+ "Safe Journey. Enjoy the Trip!\n\n");
            System.out.println("1. Register the User");
            System.out.println("2. Add Driver");
            System.out.println("3. Add Cab");
            System.out.println("4. Book Cab");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    registerUser(sc, userDAO);
                    break;

                case 2:
                    addDriver(sc, driverDAO);
                    break;

                case 3:
                    addCab(sc, cabDAO);
                    break;

                case 4:
                    bookCab(sc, bookingService);
                    break;

                case 5:
                    System.out.println("Exiting Application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    // =============================

    private static void registerUser(Scanner sc, UserDAO userDAO) {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(name, email, password);
        userDAO.registerUser(user);
    }

    private static void addDriver(Scanner sc, DriverDAO driverDAO) {
int count=0;

        System.out.print("Enter Driver Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Driver driver = new Driver(count++,name, phone, true);
        driverDAO.addDriver(driver);
    }

    private static void addCab(Scanner sc, CabDAO cabDAO) {

        System.out.print("Enter Cab Number: ");
        String cabNumber = sc.nextLine();

        System.out.print("Enter Cab Type (Mini/Sedan/SUV): ");
        String cabType = sc.nextLine();

        System.out.print("Enter Driver ID: ");
        int driverId = sc.nextInt();
       

        Cab cab = new Cab(cabNumber, cabType, true, driverId);
        cabDAO.addCab(cab);
    }

    private static void bookCab(Scanner sc, BookingService bookingService) {

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Cab ID: ");
        int cabId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Pickup Location: ");
        String pickup = sc.nextLine();

        System.out.print("Enter Drop Location: ");
        String drop = sc.nextLine();

        bookingService.bookCab(userId, cabId,pickup,drop);
    }
}