package ca.georgiancollege.comp1011m2022ice4;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/*Singleton*/
public final class Utility
{
    // step1 - create a private static instance member
    private static Utility m_instance = null;
    //step2- make the default constructor private
    private Utility() {}
    // step3 - create a public static access method that returns an instance to the class
    public static Utility Instance()
    {
        // step 4 - ensure that your instance member variable is null
        if(m_instance == null)
        {
            //step5- create an instance of the class and save reference int private variable
            m_instance = new Utility();
        }
        //step 6 - return an instance (reference) of the class
        return m_instance;
    }





    /*
    This method returns the distance from start to end
    * @param start - start vector2D
    * @param end - ending vector2D
    * */
    public float Distance(Vector2D start, Vector2D end)
    {
        float diffXs = end.getX() - start.getX();
        float diffYs = end.getY() - start.getY();

        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);
    }

    public float Distance(float x1, float y1, float x2, float y2)
    {
        float diffXs = x2 - x1;
        float diffYs = y2 - y1;
        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);

    }

    /**
     * This is a helper method that configures a spinners of type Double for a Vector2D component (e.g. x or y)
     * @param spinner
     * @param min
     * @param max
     * @param default_value
     * @param increment_value
     */
    public void ConfigureVector2DSpinner(Spinner<Double> spinner, double min, double max, double default_value, double increment_value)
    {
        // configure each spinner
        //step1- define a SpinnerValueFactory
        SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, default_value, increment_value);
        // step2 - set the Value factory
        spinner.setValueFactory(spinnerValueFactory);
        //step3 - get access to the spinner's textFields
        TextField spinnerTextField = spinner.getEditor();

        //step4 - create an event listener / event handler -> Observer Pattern

        spinnerTextField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            try {
                Float.parseFloat(newValue);
            }
            catch (Exception e)
            {
                spinnerTextField.setText(oldValue);
            }
        });
    }
}