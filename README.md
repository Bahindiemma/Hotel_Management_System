# Hotel_Management_System
This program will be a room reservation system using RMI.

1. Created Guest class with public attributes name and room to capture guest information
2. Created HotelClient to print and show commands.
3. Created an interface RoomManager which is implemented by the RoomManagerImpl class.
4. Created a Revenue class with public attributes name; for guest who paid and price; for the amount paid
5. Created a Room class with public attributes type; for room type, number; for a number of rooms available, 6. price; for the price of the room per night.

STEPS FOLLOWED TO RUN THE PROGRAMS

7. Open the terminal and cd into the RMI project directory and compile .java files one at a time by running the following command: javac Guest.java, do it for all other files for compilation.
8. Then run the command: rmiregistry
9. Leave the rmiregistry terminal open and running and open another terminal and run the command: java HotelServer to start the remote server.
10. Then run command: java HotelClient list rmi://localhost:1099/HotelServer to list all command available to interact with the system.
11. and so on ........ following the screenshots in the RMI.zip file.
