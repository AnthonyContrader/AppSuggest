import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import {AppDTO} from 'src/dto/appdto';
import { HttpClient } from '@angular/common/http';


/**
 * I service sono decorati da @Injectable.
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 *
 * @author Vittorio Valent
 *
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class AppService extends AbstractService<AppDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'app';
  }

}
