# News API client library for Java

## Installation

Gradle:


Step 1)
	
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	

Step 2)
	
	dependencies {
	        implementation 'com.github.KatanMichael:NewsApiJavaClient:-SNAPSHOT'
	}
    
 ## Usage Example
 
         NewsController myNewsController = new NewsController ("API_KEY");
                 myNewsController.getNewsArticles ("android", "", "", "",
                new getArticlesListener ()
                {
                    @Override
                    public void onReceived(Article[] articles)
                    {
                        if(articles != null)
                        {
                            for(Article a: articles)
                            {
                                System.out.println (a);
                            }
                        }
                    }

                    @Override
                    public void onError(String s)
                    {
                        System.out.println (s);
                    }
                });


	

