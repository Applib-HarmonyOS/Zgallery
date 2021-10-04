[![Build](https://github.com/applibgroup/ZGallery/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/ZGallery/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_ZGallery&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_ZGallery)

<h1>ZGallery</h1>
HMOS 3rd party library to make implementing galleries more easier.  (In Progress)

It includes two abilities :

  a. For displaying a list of images in GridLayout.<br/>
  b. For displaying images in a PageSlider with a nice scroll HorizontalList and nice zooming gestures.

<h2>How it works</h2>

<h3>Grid List Builder</h3>

Simply with a very nice builder you will find it done.

<div class="highlight highlight-source-java position-relative" data-snippet-clipboard-copy-content="ZGrid.with(this, /*your string arraylist of image urls*/)
                .setToolbarColorResId(Color.BLACK.getValue()) // toolbar color
                .setTitle(&quot;ZGallery&quot;) // toolbar title
                .setToolbarTitleColor(Color.WHITE.getvalue()) // toolbar title color
                .setSpanCount(3) // colums count
                .setGridImgPlaceHolder(Color.BLACK.getValue()) // color placeholder for the grid image until it loads
                .show();
"><pre><span class="pl-smi">ZGrid</span><span class="pl-k">.</span>with(<span class="pl-c1">this</span>, <span class="pl-c"><span class="pl-c">/*</span>your string arraylist of image urls<span class="pl-c">*/</span></span>)
                .setToolbarColorResId(<span class="pl-smi">Color</span><span class="pl-k">.</span>BLACK<span class="pl-k">.</span>getValue()) <span class="pl-c"><span class="pl-c">//</span> toolbar color</span>
                .setTitle(<span class="pl-s"><span class="pl-pds">"</span>Zak Gallery<span class="pl-pds">"</span></span>) <span class="pl-c"><span class="pl-c">//</span> toolbar title</span>
                .setToolbarTitleColor(<span class="pl-smi">Color</span><span class="pl-c1"><span class="pl-k">.</span>WHITE.getValue()</span>) <span class="pl-c"><span class="pl-c">//</span> toolbar title color</span>
                .setSpanCount(<span class="pl-c1">3</span>) <span class="pl-c"><span class="pl-c">//</span> colums count</span>
                .setGridImgPlaceHolder(<span class="pl-smi">COLOR</span><span class="pl-k">.</span>WHITE<span class="pl-k">.</span>getValue()) <span class="pl-c"><span class="pl-c">//</span> color placeholder for the grid image until it loads</span>
                .show();</pre></div>
<h3><a id="user-content-gallery-builder" class="anchor" aria-hidden="true" href="#gallery-builder"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Gallery Builder</h3>
<div class="highlight highlight-source-java position-relative" data-snippet-clipboard-copy-content="ZGallery.with(this, /*your string arraylist of image urls*/)
                .setToolbarTitleColor(Color.WHITE.getValue()) // toolbar title color
                .setGalleryBackgroundColor(Color.WHITE.getValue()) // activity background color
                .setToolbarColorResId(Color.BLACK.getValue()) // toolbar color
                .setTitle(&quot;ZGallery&quot;) // toolbar title
                .show();
"><pre><span class="pl-smi">ZGallery</span><span class="pl-k">.</span>with(<span class="pl-c1">this</span>, <span class="pl-c"><span class="pl-c">/*</span>your string arraylist of image urls<span class="pl-c">*/</span></span>)
                .setToolbarTitleColor(<span class="pl-smi">Color</span><span class="pl-c1"><span class="pl-k">.</span>WHITE.getValue()</span>) <span class="pl-c"><span class="pl-c">//</span> toolbar title color</span>
                .setGalleryBackgroundColor(<span class="pl-smi">Color</span><span class="pl-c1"><span class="pl-k">.</span>WHITE.getValue()</span>) <span class="pl-c"><span class="pl-c">//</span> activity background color</span>
                .setToolbarColorResId(<span class="pl-smi">COLOR</span><span class="pl-k">.</span>BLACK<span class="pl-k">.</span>getValue()) <span class="pl-c"><span class="pl-c">//</span> toolbar color</span>
                .setTitle(<span class="pl-s"><span class="pl-pds">"</span>Zak Gallery<span class="pl-pds">"</span></span>) <span class="pl-c"><span class="pl-c">//</span> toolbar title</span>
                .show();</pre></div>

<h3>Installation</h3>

Add this to your module build.gradle file:

dependencies {<br/>
  ...<br/>
    implementation project(path: ':zgallery')<br/>
}<br/>

<h1><a id="user-content-license" class="anchor" aria-hidden="true" href="#license"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>License</h1>
<blockquote>
<p>Copyright 2016 mzelzoghbi</p>
</blockquote>
<blockquote>
<p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at</p>
</blockquote>
<blockquote>
<p><a href="http://www.apache.org/licenses/LICENSE-2.0" rel="nofollow">http://www.apache.org/licenses/LICENSE-2.0</a></p>
</blockquote>
<blockquote>
<p>Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.</p>
</blockquote>
