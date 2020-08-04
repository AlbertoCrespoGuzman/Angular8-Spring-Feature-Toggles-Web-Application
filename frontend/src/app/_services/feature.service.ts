import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '@environments/environment';
import { Feature } from '@app/_models';

@Injectable({ providedIn: 'root' })
export class FeatureService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Feature[]>(`${environment.apiUrl}/features`);
    }

    createFeature(feature: Feature) {
        return this.http.post<any>(`${environment.apiUrl}/features`, feature  )
            
    }
}