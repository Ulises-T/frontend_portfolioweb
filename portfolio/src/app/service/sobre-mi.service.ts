import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SobreMi } from '../classes/SobreMi';

@Injectable({
  providedIn: 'root'
})

export class SobreMiService {
  URL= 'http://localhost:5000/SobreMi';

  constructor(
    private http: HttpClient
  ) { }

  getSobreMi():Observable<SobreMi>{    
    return this.http.get<SobreMi>(this.URL+'/1');
}
}
