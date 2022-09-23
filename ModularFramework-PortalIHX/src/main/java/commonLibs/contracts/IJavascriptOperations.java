package commonLibs.contracts;

public interface IJavascriptOperations {

	public void executeJavaScript(String scriptToExecute) throws Exception;

	public void scrollDown(int x, int y) throws Exception;

	public String executeJavaScriptWithRetrunValue(String scriptToExecute) throws Exception;

}