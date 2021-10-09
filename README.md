[![Build](https://github.com/applibgroup/ZGallery/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/ZGallery/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_ZGallery&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_ZGallery)

# ZGallery
HMOS 3rd party library to make implementing galleries more easier. 
It includes two abilities :

a. For displaying a list of images in GridLayout.<br/>
b. For displaying images in a PageSlider with a nice scroll HorizontalList and nice zooming gestures.
<p>
	<image src = "/zgrid.png" width = 320 height = 512)/>
	<image src = "/zgallery.png" width = 320 height = 512)/>
</p>

# Source
This library has been inspired by [mzelzoghbi/ZGallery](https://github.com/mzelzoghbi/ZGallery).

## Integration

1. For using ZGallery module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
 implementation project(path: ':ZGallery')
```
2. For using ZGallery module in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
 implementation fileTree(dir: 'libs', include: ['*.har'])
```
3. For using ZGallery module from a remote repository in separate application, add the below dependencies in entry/build.gradle file.
```
implementation 'dev.applibgroup:ZGallery:1.0.0'
```

## Usage
 1. GridBuilder

Example:

```java
    ZGrid.with(this, /*your string arraylist of image urls*/)
                .setToolbarColorResId(Color.BLACK.getValue()) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .setToolbarTitleColor(Color.WHITE.getValue()) // toolbar title color
                .setSpanCount(3) // colums count
                .setGridImgPlaceHolder(COLOR.WHITE.getValue()) // color placeholder for the grid image until it loads
                .show();
```

1. GalleryBuilder

Example:

```java
    ZGrid.with(this, /*your string arraylist of image urls*/)
                .setToolbarColorResId(Color.BLACK.getValue()) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .setToolbarTitleColor(Color.WHITE.getValue()) // toolbar title color
                .setSpanCount(3) // colums count
                .setGridImgPlaceHolder(COLOR.WHITE.getValue()) // color placeholder for the grid image until it loads
                .show();
```
Check the example app for more information.

## License

	Copyright 2016 mzelzoghbi

	Licensed under the Apache License, Version 2.0 (the "License"); 
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, 
	software distributed under the License is distributed on an 
	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
	either express or implied. See the License for the specific 
	language governing permissions and limitations under the License.
