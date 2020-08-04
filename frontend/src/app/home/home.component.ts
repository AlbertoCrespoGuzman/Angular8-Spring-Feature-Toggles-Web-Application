import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { Feature } from '@app/_models';
import { FeatureService } from '@app/_services';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    loading = false;
    features: Feature[];

    constructor(private featureService: FeatureService) { }

    ngOnInit() {
        this.loading = true;
        this.featureService.getAll().pipe(first()).subscribe(features => {
            this.loading = false;
            this.features = features;
        });
    }
}