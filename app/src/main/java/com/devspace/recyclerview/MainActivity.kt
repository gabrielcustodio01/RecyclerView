package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

private val contacts = listOf(
    Contact("Gabriel", "351 999 999 999", R.drawable.sample2),
    Contact("Maria", "351 999 999 998", R.drawable.sample1),
    Contact("João", "351 999 999 997", R.drawable.sample3),
    Contact("Ana", "351 999 999 996", R.drawable.sample4),
    Contact("Pedro", "351 999 999 995", R.drawable.sample5),
    Contact("Carla", "351 999 999 994", R.drawable.sample6),
    Contact("Rafael", "351 999 999 993", R.drawable.sample7),
    Contact("Luisa", "351 999 999 992", R.drawable.sample8),
    Contact("Paulo", "351 999 999 991", R.drawable.sample9),
    Contact("Fernanda", "351 999 999 990", R.drawable.sample10),
    Contact("Lucas", "351 999 999 989", R.drawable.sample11),
    Contact("Beatriz", "351 999 999 988", R.drawable.sample12),
    Contact("Ricardo", "351 999 999 987", R.drawable.sample13),
    Contact("Camila", "351 999 999 986", R.drawable.sample14),
    Contact("André", "351 999 999 985", R.drawable.sample15),
    Contact("Patrícia", "351 999 999 984", R.drawable.sample16)
)