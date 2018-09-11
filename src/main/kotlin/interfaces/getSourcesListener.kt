package interfaces
import model.Source

interface getSourcesListener
{
    fun onError(error: String?)
    fun onReceived(sources : Array<Source>?)

}