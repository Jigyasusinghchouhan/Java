import java.awt.*;
import java.awt.event.*;

public class question2 extends Frame implements ActionListener {
    private Label hotelNameLabel, roomsLabel, amenitiesLabel, contactLabel,
            hotelNameText;
    private TextField roomsText, amenitiesText, contactText;
    private Button submitButton, exitButton;

    public question2() {
        // Set the frame properties
        setTitle("Hotel Website");
        setSize(500, 400);
        setLayout(new GridLayout(5, 2));
        setVisible(true);
        // Add the labels and text fields for hotel name, number of rooms,
        // amenities, and contact information
        hotelNameLabel = new Label("Hotel Name: ");
        add(hotelNameLabel);
        hotelNameText = new Label(" Sunrise Hotel ");
        add(hotelNameText);
        roomsLabel = new Label("Number of Rooms:");
        add(roomsLabel);
        roomsText = new TextField();
        add(roomsText);
        amenitiesLabel = new Label("Amenities:");
        add(amenitiesLabel);
        amenitiesText = new TextField();
        add(amenitiesText);
        contactLabel = new Label("Contact Information:");
        add(contactLabel);
        contactText = new TextField();
        add(contactText);
        // Add the submit and exit buttons
        submitButton = new Button("Submit");
        add(submitButton);
        submitButton.addActionListener(this);
        exitButton = new Button("Exit");
        add(exitButton);
        exitButton.addActionListener(this);
        // Set the default close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String hotelName = hotelNameText.getText();
            int numberOfRooms = Integer.parseInt(roomsText.getText());
            String amenities = amenitiesText.getText();
            String contactInfo = contactText.getText();
            System.out.println("Hotel Name: " + hotelName);
            System.out.println("Number of Rooms: " + numberOfRooms);
            System.out.println("Amenities: " + amenities);
            System.out.println("Contact Information: " + contactInfo);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new question2();
    }
}