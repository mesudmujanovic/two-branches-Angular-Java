import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ImageInfo } from '../ImageInfo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LandMarkService {
private apiUrl = `http://localhost:8080/image/upload`;
private getAll = `http://localhost:8080/image/allImages`;
private onlyImages = `http://localhost:8080/image/allImagesImage`;
private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  uploadImage(file: File, name: string, description: string, latitude: string, longitude: string) {
    const formData = new FormData();
    formData.append('file', file);
    formData.append('name', name);
    formData.append('description', description);
    formData.append('latitude', latitude);
    formData.append('longitude', longitude);

    return this.http.post<any>(this.apiUrl, formData);
  }

  getAllImages() {
    return this.http.get<ImageInfo[]>(`${this.getAll}`);
  }

  getAllImagesOnly(){
    return this.http.get<any>(`${this.onlyImages}`)
  }
  
  searchImagesByImportance(importance: string): Observable<ImageInfo[]> {
    const url = `${this.baseUrl}/image/searchByImportance?importance=${importance}`;
    return this.http.get<ImageInfo[]>(url);
  }
}
