# Summary

My goal was to implement the given requirements as close as possible using modern android tools and 
MVVM as the architecture. My first step was to create the data foundation which uses Retrofit and 
RxJava to serve models to the view model. The view model then takes the response of the Rx 
observable and puts it on a LiveData observable for the Activity to consume. Once the activiy 
has the list of Manager Specials, they get added to an Android RecyclerView using a 
[FlexboxLayoutManager](https://github.com/google/flexbox-layout) for display. This was my first 
experience with server driven UI so there is still plenty of work to be done, especially at the UI 
level, to get the app to acceptable level. These improvements are listed below.

## Design Decisions

- MVVM was used for it's simplicity and follows Google's recommendation for application architecture
- Did not use Android Architecture ViewModel as it adds to the complexity of injection using Dagger. 
Since handling a screen rotation was not part of the requirements there was no benefit for this added
complexity
- Originally used Airbnb's [Epoxy](https://github.com/airbnb/epoxy) for the list but it doesn't seem
to play nice with FlexboxLayout. Therefore, I decided to use vanilla RecyclerView instead
- ManagerSpecialsViewCalculator is at the view layer, but I also thought about putting it at the view
model layer. Since the calculator needs the screen width, which require context to retrieve, I decided
to have the Activity have the dependency instead of the view model. 

## Improvements

- UI needs massive cleanup. Need to to make sure views within each item do not overlap
- Inject the ManagerSpecialsViewCalculator
- Add tests in general, but especially for the ManagerSpecialsViewCalculator
- Inject the ManagerSpecialsAdapter
- Add scoping for injections into the Activity
- Create caching of data for better offline experience
- Handle network errors on requests


## Installation

Clone repository to local machine. Attach an android device or start emulator with sdk version > 17

Run installation command
`/gradlew app:installDebug`



