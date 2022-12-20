package assembler.new_commitment;

import javax.swing.*;
import java.awt.*;
import java.time.Year;
import java.util.ArrayList;

public class DateField extends JPanel {

    protected JSpinner day, month, year;

    public DateField() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        ArrayList<JPanel> panels = new ArrayList<>();
        ArrayList<JSpinner> spinners = new ArrayList<>();

        JPanel dayPanel     = new JPanel();
        JPanel monthPanel   = new JPanel();
        JPanel yearPanel    = new JPanel();

        day     = new JSpinner
                (new SpinnerNumberModel(1, 1, 31, 1));
        month   = new JSpinner
                (new SpinnerNumberModel(1, 1, 12, 1));
        year    = new JSpinner(new SpinnerNumberModel
                (Year.now().getValue(), Year.now().getValue(), 9999, 1));

        day.setName("Day");
        month.setName("Month");
        year.setName("Year");

        spinners.add(day);
        spinners.add(month);
        spinners.add(year);

        panels.add(dayPanel);
        panels.add(monthPanel);
        panels.add(yearPanel);

        for (int i = 0; i < panels.size(); i++){
            panels.get(i).setLayout(new GridLayout(2, 1));
            panels.get(i).add(spinners.get(i));
            panels.get(i).add(new JLabel(spinners.get(i).getName()));
            add(panels.get(i));
            add(Box.createRigidArea(new Dimension(10, 0)));

        }

    }

    public String toString(){
        return String.format("%d-%d-%d", (int)year.getValue(), (int)month.getValue(), (int)day.getValue());
    }

    public String toDateString(){
        return String.format("%d/%d/%d", (int)day.getValue(), (int)month.getValue(), (int)year.getValue());
    }
}
