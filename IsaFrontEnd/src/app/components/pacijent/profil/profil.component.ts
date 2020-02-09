import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { Korisnik } from 'src/app/model/Korisnik';
import { ToastrModule, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  trenutniKorisnik: Korisnik=new Korisnik();
  ime : string = ""; 
  prezime : string = "";
  email : string = "";
  grad : string = "";
  novaLozinka : string = "";
  ponovljenaLozinka : string = "";
  signal : boolean = true;

  constructor(private router : Router, private route : ActivatedRoute, private service: KorisnikService, private toastr: ToastrService) { }

  ngOnInit() {
    
    this.service.vratiTrenutnogKorisnika().subscribe(
      data =>{
        this.trenutniKorisnik=data;
      },
      error => {
        console.log(error);
      }
    )
  }

  odustani(){
    this.router.navigate(["pocetnaPacijent"],{relativeTo: this.route}); 
  }

  izmijeniPodatke(){
    if(this.novaLozinka == ""){
      this.trenutniKorisnik.password = this.trenutniKorisnik.pomLozinka;
    } else {
      if(this.novaLozinka == this.ponovljenaLozinka){
        this.trenutniKorisnik.password = this.novaLozinka;
        this.trenutniKorisnik.pomLozinka = this.novaLozinka;
        this.signal = true;
      } else {
        this.signal = false;
        // this.toastr.error("Lozinke se ne poklapaju!", this.trenutniKorisnik.ime);
        alert('Lozinke se ne poklapaju!');
      }
      
    }
    if(this.signal) {
      this.service.izmjenaPodataka(this.trenutniKorisnik).subscribe(
        data => {
          // this.toastr.success("Uspesno ste promenili podatke!", this.trenutniKorisnik.ime);
          alert('Uspesno ste promenili podatke!');
        },
        error => {
    
        }
      );
    }
    
  }

}
