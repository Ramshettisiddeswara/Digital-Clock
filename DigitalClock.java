import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock extends JFrame {
    private JLabel clockLabel;

    public DigitalClock() {
        // Set up the clock window
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and style the clock label
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setVerticalAlignment(SwingConstants.CENTER);

        add(clockLabel, BorderLayout.CENTER);

        // Start the clock thread to update time
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock(); // Set initial time
    }

    private void updateClock() {
        // Get current time and format it
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        formatter.setTimeZone(TimeZone.getDefault());
        String currentTime = formatter.format(new Date());
        clockLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}
