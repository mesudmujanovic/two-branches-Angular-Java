import { Component } from '@angular/core';
import { ImageInfo } from 'src/app/ImageInfo';
import { LandMarkService } from 'src/app/service/land-mark.service';

@Component({
  selector: 'app-land-mark',
  templateUrl: './land-mark.component.html',
  styleUrls: ['./land-mark.component.css']
})
export class LandMarkComponent {
  selectedFile: File;
  images: string[]=[];
  imgs: ImageInfo[];
  imagesSearch: ImageInfo[];
   importance: string = '';


  constructor(private landMarkService: LandMarkService){}


  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
    const name = 'Your image name';
    const description = 'Your image description';
    const latitude = 'Your image latitude';
    const longitude = 'Your image longitude';

    this.landMarkService.uploadImage(this.selectedFile, name, description, latitude, longitude)
      .subscribe(
        (response) => {
          console.log('Image uploaded successfully:', response);
        },
        (error) => {
          console.error('Error uploading image:', error);
        }
      );
  };

  getAllImages() {
    this.landMarkService.getAllImages()
      .subscribe(
        (response: ImageInfo[]) => {
          console.log('All images:', response);
         this.imgs = response;
         console.log("imgsss",this.imgs);          
        },
        (error) => {
          console.error('Error getting images:', error);
        }
      );
  }

  getOnlyImages(){
    this.landMarkService.getAllImagesOnly().subscribe(
      (response: any) => {
     this.images = response.map( image => 'data:image/jpeg;base64,' + image )
      },
      (error) => {
        console.log("error",error);
      }
    )
  }

  searchImagesByImportance(importance: string): void {
    this.landMarkService.searchImagesByImportance(importance)
      .subscribe(images => this.imagesSearch = images);
  }

  getImageUrl(content: string): string {
    const imageUrl = `data:image/jpeg;base64,${content}`;
    return imageUrl;
  }
  
  

  ngOnInit(){
    this.getAllImages();
    this.getOnlyImages()
  }
}
