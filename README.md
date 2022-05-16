# AddTextToVideo
## The app has one screen composing of: a text field, a ‘Get joke’ button, a ‘Select video’ button and a Save button. As a user, we can choose the video file from the Gallery by tapping on the Add button. After the video is chosen, I can get a random joke from the API http://api.icndb.com/jokes/random, taping on the Get joke button. The received joke appears in the text field on the screen. After the joke is received and displayed, I can tap the Save button, and the app should save to the Gallery the selected video with the joke overlay at the top. The saved video should have the same aspect ratio as an original video.

##Tech stack

## MVVM architecture, LiveData and Coroutines (for multithreading). No use of any 3rd party libraries for the rendering goals. The language is Kotlin.
