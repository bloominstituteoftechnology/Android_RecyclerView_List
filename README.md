# Android_RecyclerView_List

## Introduction

In this project, we'll be changing some of the scrollviews from previous projects to Recycler Views. This will give you more practice building up the Recycler View and less time building the foundation of the app.

## Instructions

### Part 1 - Favorite Pictures Gallery

For this project, I'll walk you through the transition

#### Prep Project
1. Go to your `Module`'s `build.gradle` file and add the `RecyclerView` dependency `implementation 'com.android.support:recyclerview-XXXXXXX`
2. Replace the `XXXXXXX` with whatever version appcompat library you are using.
> Example if the appcompat line is `implementation 'com.android.support:appcompat-v7:28.0.0-rc01`, use `v7:28.0.0-rc01` for the `RecyclerView`

#### List Item Layout
1. Decide what information from the `ImageData` method would be useful to display in the List Activity
2. Build a layout to display that content called `image_item_layout` (this is up to you to decide what you think looks good, have fun and play around with views and attributes)
3. Give each element in this layout an id to be able to access it in the list adapter

#### Build List Adapter
1. Create a class called `ImageListAdapter` that `extends` `RecyclerView.Adapter<ImageListAdapter.ViewHolder>`
2. Create an Inner Class called `ViewHolder` which `extends` `RecyclerView.ViewHolder`
3. Add data members to this `ViewHolder` class for each of the views in your item layout
4. Add a constructor to the `ViewHolder` that accepts a `View` object
5. In the constructor, call the super constructor passing the view object to it with `super(view);`
6. Attach all the views in the layout to the corresponding data members using `view.findViewById`
7. In the `ImageListAdapter` class, add a data member for an `ArrayList` of `ImageData` objects and one for a `Context` object
8. Write a constructor method which accepts and stores the `ArrayList` member
9. Override the `onCreateViewHolder` method
> The signature should look like this `public ImageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  

10. `Inflate` your item layout to a `View` object using `LayoutInflater.from(context).inflate(R.layout.image_list_view, parent, false);`
11. Pass this `View` object to a `ViewHolder` constructor and return the new `ViewHolder` object
12. Override the `onBindViewHolder` method using the signature `public void onBindViewHolder(ImageListAdapter.ViewHolder holder, int position)`
13. Use the passed position parameter to `get` the `ImageData` object at that position of the `ArrayList`
14. Take that object and use it to populate your layout
> Remember, you have already bound the elements of your layout to your `ViewHolder` object and can now access them through the passed instance of that object, `holder.textImageName.setText(data.getName())`  
> Be sure to move your `OnClickListener` from the `TextView` generator in your `MainActivity` to this method. Remember to use `context.startActivity` to start the details activity
 
#### Attach List To Activity
Now that we have built the components for our `RecyclerView`, it's time to bolt it all together
1. Change your layout xml file to remove the `ScrollView` and `LinearLayout` and replace them with a single `RecyclerView`
2. Add data members for a `RecyclerView`, `LayoutManager` (You can pick what you want, Linear, Grid, or Staggered), and your `ImageListAdapter`
3. In your `OnCreate` method, attach your `RecyclerView`
4. Call `setHasFixedSize(true)` on your `RecyclerView` object
5. Create a new `LayoutManager` of the type you chose before. Check the corresponding documentation for information on the constructors for your chosen manager
6. Call `setLayoutManager` on your `RecyclerView`, passing it your new `LayoutManager`
7. Create a new instance of your `ImageListAdapter`, passing it the `ArrayList` of `ImageData` objects that you created last time
8. Call `setAdapter` on your `RecyclerView`, passing it your instance of `ImageListAdapter`

#### Handle List Updates
Since we are going to be manually adding elements to the `ArrayList`, we'll have to notify the `ListAdapter` when we do so.
1. In your `onActivityResult` method, after adding an image to the list, call `notifyItemInserted()` on the listadapter and pass it the index of the element you just added (size - 1)
2. Check to make sure that if there are any other times where you edit elements in the array you are calling either `notifyItemInserted()` with the affected element or `notifyItemInserted()` without passing anything

#### Test Your App
Make sure the images you add are added to the ui and that you can select them to go into the details view

### Part 2 - Another App
Chose another app which we have built or one you build on your own and implement a `RecyclerView` in it.

#### Challenge
In your testing, find bugs and small feature improvements that can improve the polish of your app.
