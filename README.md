# ZGallery
HMOS 3rd party library to make implementing galleries more easier.

It includes two abilities :

For displaying a list of images in GridLayout.
For displaying images in a PageSlider with a nice scroll HorizontalList and nice zooming gestures.

How it works

Grid List Builder
Simply with a very nice builder you will find it done.

ZGrid.with(this, /*your string arraylist of image urls*/)
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setSpanCount(3) // colums count
                .setGridImgPlaceHolder(R.color.colorPrimary) // color placeholder for the grid image until it loads
                .show();
Gallery Builder
ZGallery.with(this, /*your string arraylist of image urls*/)
                .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setGalleryBackgroundColor(ZColor.WHITE) // activity background color
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .show();
Installation

Add this to your module build.gradle file:

dependencies {
  ...
    implementation project(path: ':zgallery')
}
