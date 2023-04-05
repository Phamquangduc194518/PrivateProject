import android.os.AsyncTask
import com.example.asynctask.News
import com.example.asynctask.NewsAdapter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class XmlDownloader(private val newsAdapter: NewsAdapter) : AsyncTask<String, Void, List<News>>() {
    private val link = "https://cdn.24h.com.vn/upload/rss/tintuctrongngay.rss"

    override fun doInBackground(vararg params: String?): List<News>? {
        val url = params[0]
        val inputStream = URL(link).openStream()
        return parseXml(inputStream)
    }

    private fun parseXml(inputStream: InputStream): List<News> {
        val rsses = mutableListOf<News>()
        try {
            val rd = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            for (i in 0..15) {
                rd.readLine()
            }
            while (true) {
                val line = rd.readLine()
                if (line == null || line.startsWith("<link>")) {
                    break
                }
                var title = rd.readLine()
                if (title == "<title>") {
                    title = rd.readLine()
                    rd.readLine()
                } else {
                    title = title.replace("<title>", "")
                    title = title.replace("</title>", "")
                }
                rd.readLine()
                rd.readLine()
                var description = rd.readLine()
                var imageLink: String? = null
                val indexImage = description.indexOf("src='h")
                if (indexImage > 0) {
                    imageLink = description.substring(indexImage + "src='".length)
                    imageLink = imageLink.substring(
                        0,
                        imageLink.indexOf("' alt")
                    )
                }
                val index = description.indexOf("alt='")
                description = description.substring(index + "alt='".length)
                val indexEnd = description.indexOf("' />")
                description = description.substring(0, indexEnd)
                rd.readLine()
                rd.readLine()
                var publicDate = rd.readLine()
                publicDate = publicDate.replace("<pubDate>", "")
                publicDate = publicDate.replace("</pubDate>", "")
                var htmlLink = rd.readLine()
                htmlLink = htmlLink.replace("<link>", "")
                htmlLink = htmlLink.replace("</link>", "")
                rd.readLine()
                rd.readLine()
                rsses.add(News(title, description,imageLink!!))
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return rsses
    }

    override fun onPostExecute(result: List<News>?) {
        super.onPostExecute(result)
        newsAdapter.UpdateData(result as ArrayList<News>)
    }
//    override fun onPostExecute(result: List<News>?) {
//        result?.let {
//            newsAdapter.UpdateData(it as ArrayList<News>)
//        }
//    }
}