package com.example.appcommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcommerce.adapter.ProductAdapter
import com.example.appcommerce.adapter.ProductCategoryAdapter
import com.example.appcommerce.model.Product
import com.example.appcommerce.model.ProductCategory
import com.example.appcommerce.model.ProductColor
import com.example.appcommerce.model.ProductSize

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        ProductCategoryFragment.Callback
    {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var textTitle: TextView
    lateinit var textLogin: TextView
    lateinit var recyclerCategory: RecyclerView
    lateinit var recyclerProduct: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.app_name)

        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toogle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toggle_open, R.string.toggle_close)
        drawerLayout.addDrawerListener(toogle)

        toogle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        //Categorias
        recyclerCategory = findViewById(R.id.rv_main_product_category)
        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory("1", "Camisetas", fillRvProduct()),
            ProductCategory("2", "Calças", fillRvProduct()),
            ProductCategory("2", "Calçados", fillRvProduct()),
            ProductCategory("2", "Blusas", fillRvProduct()))
        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //Produtos
        recyclerProduct = findViewById(R.id.rv_main_product)
        val adapterProduct = ProductAdapter(fillRvProduct(), this)

        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    fun fillRvProduct(): List<Product> {
        val product: Product = Product(
            "1","Camiseta Branca",
            ProductCategory("id", "Camisetas"),
            "camiseta super leve para exercicio",
            19.90,
            arrayListOf(ProductColor("1", "Branco", "#FFFFFF"),ProductColor("1", "Preto", "#000000")),
            arrayListOf(ProductSize("1", "M"),ProductSize("2", "G")), emptyList()
        )

        val product2: Product = Product(
            "1","Calça Jeans",
            ProductCategory("id", "Calças"),
            "calça jeans super confortavel",
            19.90,
            arrayListOf(ProductColor("1", "Azul", "#F584B4"),ProductColor("1", "Preto", "#000000")),
            arrayListOf(ProductSize("1", "P"),ProductSize("2", "GG")), emptyList()
        )

        return arrayListOf(product, product2)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_account -> {
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_category -> {
                val intent = Intent(this, ProductCategoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_orders -> Toast.makeText(this, "pedidos", Toast.LENGTH_LONG).show()
            R.id.nav_cart -> Toast.makeText(this, "carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout-> Toast.makeText(this, "sair", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

        override fun itemSelected(category: ProductCategory) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("CATEGORY", category)
            startActivity(intent)
        }
    }