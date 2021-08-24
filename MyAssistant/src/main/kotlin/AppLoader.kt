import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader

class AppLoader {
    suspend fun LoadAll() = coroutineScope {
        File("/home/arjun/tutorials/").walk().forEach {
            if(it.isFile || it.extension == "jar") {

                launch {
                val child: URLClassLoader = URLClassLoader(
                    arrayOf<URL>(File("/Users/67981/IdeaProjects/TestSDK/src/main/resources/TestSDK-1.0-SNAPSHOT.jar").toURI().toURL()), AppLoader().javaClass.classLoader
                )
                val classToLoad = Class.forName("Hello", true, child)
                val method: Method = classToLoad.getDeclaredMethod("hello")
                val instance = classToLoad.newInstance()
                val result: Any? = method.invoke(instance)
                }
            }
        }
    }
}