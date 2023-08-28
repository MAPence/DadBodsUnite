import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RestaurantActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_layout)


        val table1Button = findViewById<Button>(R.id.table1Button)
        val table2Button = findViewById<Button>(R.id.table2Button)
        val table3Button = findViewById<Button>(R.id.table3Button)
        val table4Button = findViewById<Button>(R.id.table4Button)
        val table5Button = findViewById<Button>(R.id.table5Button)

        table1Button.setOnClickListener {
        }

        table2Button.setOnClickListener {
        }

        table3Button.setOnClickListener {
        }

        table4Button.setOnClickListener {
        }

        table5Button.setOnClickListener {
        }


        }
        }