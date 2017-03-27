import { Observable } from 'rxjs/Rx';
export interface Removeable {
    delete(): Observable<any>;
}
