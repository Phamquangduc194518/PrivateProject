package com.example.demorecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),
    ChattingAdapter.IChattingAdapter {
    private lateinit var rcChatting: RecyclerView
    private lateinit var adapter: ChattingAdapter
    private val chattings = mutableListOf<Chatting>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcChatting = findViewById(R.id.rc_chatting)

        adapter = ChattingAdapter()
        rcChatting.adapter = adapter
        adapter.setOnIChatting(this)
        rcChatting.setOnClickListener { }

        adapter.setOnClickItemChatting(object : ChattingAdapter.OnClickItemChatting{
            override fun onClickItemChatting(position: Int) {
                Toast.makeText(baseContext, "position: "+ position.toString(), Toast.LENGTH_SHORT).show()
            }
        })
//        adapter.setOnClickItemChatting({ it ->
//            Toast.makeText(this, "position: "+ it.toString(), Toast.LENGTH_SHORT).show()
//            return@setOnClickItemChatting true
//        })

        rcChatting.layoutManager = LinearLayoutManager(this)

        initData()

        adapter.notifyDataSetChanged()
    }

    private fun initData() {
        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤",
                true
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )


        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )

        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )

        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )

        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )

        chattings.add(
            Chatting(
                "Jony Nguyen",
                "http://giadinh.mediacdn.vn/2021/1/31/photo-1-16120884642841668880329.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Jony Chi",
                "https://tophinhanh4k.com/wp-content/uploads/2022/01/hot-girl-ao-dai.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Minh Nguyen",
                "https://tailocwedding.vn/wp-content/uploads/2022/11/thuyet-minh-ve-ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Linh Nguyen",
                "https://halongbayviewcodotel.com/wp-content/uploads/2021/07/ao-dai-viet-nam.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hằng Nguyễn",
                "http://bizweb.dktcdn.net/thumb/grande/100/236/196/products/ao-dai-in-3d-6.jpg?v=1586768905567",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Hồng Đăng",
                "https://anhgaisexy.com/wp-content/uploads/2022/02/bo-anh-nu-sinh-ao-dai-sexy-chat-luong-nhat-617x925.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Nguyễn",
                "https://cdn.alongwalk.info/vn/wp-content/uploads/2022/05/22052222/image-101-anh-ao-dai-sexy-gai-xinh-mac-ao-dai-dep-nhat-2022-165314654289711.jpg",
                "Hello world, i have just see the world firstly and I hope so i will meet more lucky. Thanks ❤️❤❤"
            )
        )
        chattings.add(
            Chatting(
                "Thúy Chi",
                "https://2.pik.vn/20189c0d5e01-7251-4e28-807a-c094f3cac731.jpg",
                "Hello world!!! testiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Tai Ho",
                "https://live.staticflickr.com/65535/51174937165_3ab2addef1_k.jpg",
                "Hello world!!! ahiiiiiiiiiiiiiiii"
            )
        )
        chattings.add(
            Chatting(
                "Bach Bao",
                "https://i.imgur.com/CQ7f99K.jpg",
                "Hello world!!!, Vipppingggggggggggg"
            )
        )
        chattings.add(
            Chatting(
                "Trà Nguyễn",
                "https://farm5.staticflickr.com/4513/36857530543_0e1834a7d1_o.jpg",
                "Hello world!!!, manyyyyyyyyyyyy"
            )
        )
        chattings.add(
            Chatting(
                "Thúy",
                "https://hoanglamcm.net/ao-dai-mong-goi-cam/imager_12_17298_700.jpg",
                "Hello world!!! Goodddddd"
            )
        )
    }

    override fun getSizeChatting(): Int {
        return chattings.size
    }

    override fun getChattingData(position: Int): Chatting {
        return chattings[position]
    }

    override fun removeChatting(position: Int) {
        chattings.removeAt(position)
    }
}