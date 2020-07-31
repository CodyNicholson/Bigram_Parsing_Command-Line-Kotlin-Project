# Bigram Parser CLI Project

This is a Kotlin CLI app that takes in a filepath argument and outputs a histogram of the bigrams in the provided file. To use this app, go to the root of the project in your 
terminal or command prompt (This app was built and tested on Windows) and run:

```
java -jar cli-app/build/libs/cli-app.jar -f textFile.txt
```

To build this app into that jar and run all of the tests, from the project root run the command:

```
gradle cli-app:packageDistribution
```

Before I made the above gradle task, I would use this command and move my jar into my :

```
gradle clean cli-app:jar
```

Of you can run the task I made which will 

Thanks for looking at my work!
