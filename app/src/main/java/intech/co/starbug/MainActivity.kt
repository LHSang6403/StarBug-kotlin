package intech.co.starbug
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.util.Pair
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import intech.co.starbug.activity.CommentActivity
import intech.co.starbug.activity.CommentFormActivity
import intech.co.starbug.activity.product.DetailProductActivity
import intech.co.starbug.activity.authentication.LoginActivity


class MainActivity : AppCompatActivity() {

    private lateinit var topAnim: Animation;
    private lateinit var bottomAnim: Animation;
    private lateinit var image: ImageView;
    private lateinit var logoTV: TextView;
    private lateinit var sloganTV: TextView;
    private lateinit var companyTV: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hide the system bar
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        logoTV = findViewById(R.id.textViewBrand);
        sloganTV = findViewById(R.id.textViewSlogan);
        companyTV = findViewById(R.id.textViewCompany);

        image.setAnimation(topAnim);
        logoTV.setAnimation(bottomAnim);
        sloganTV.setAnimation(bottomAnim);
        companyTV.setAnimation(bottomAnim);

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            val pairs = arrayOf<Pair<View, String>>(
                Pair(image, "logo_image"),
                Pair(logoTV, "brand_text"),
            )

            val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, *pairs)
            startActivity(intent, options.toBundle())
        }, 3000)
    }
}
