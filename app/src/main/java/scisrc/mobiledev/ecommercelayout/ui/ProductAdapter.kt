package scisrc.mobiledev.ecommercelayout.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemProductBinding

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productImage.setImageResource(product.imageResId)
            binding.productName.text = product.name
            binding.productPrice.text = product.price

            // 🔹 เปลี่ยนสีของราคาตามเงื่อนไข
            if (product.price.contains("ลดเหลือ")) {
                binding.productPrice.setTextColor(Color.RED)  // สีแดง สำหรับราคาที่ลดแล้ว
            } else {
                binding.productPrice.setTextColor(Color.BLACK)  // สีดำ สำหรับราคาปกติ
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}