import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { FeatureService } from '@app/_services';
import { Feature } from '@app/_models';

@Component({ templateUrl: 'feature.component.html' })
export class FeatureComponent {
    featureForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private featureService: FeatureService
    ) { 
        
    }

    ngOnInit() {
        this.featureForm = this.formBuilder.group({
            id:0,
            displayName: '',
            expiresOn: new Date(new Date().getTime() + 24 * 3600 * 1000).toISOString(),
            description: '',

            technicalName: ['', Validators.required],
            inverted: ['', Validators.required],
            customerIds: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.featureForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.featureForm.invalid) {
            return;
        }

        this.loading = true;

        const feature: Feature  = {
            id: this.f.id.value, 
            displayName:  this.f.displayName.value, 
            technicalName:  this.f.technicalName.value, 
            expiresOn:  new Date(this.f.expiresOn.value).getTime(), 
            description:  this.f.description.value, 
            inverted:  this.f.inverted.value, 
            customerIds:  this.f.customerIds.value.split(',')
        }
        this.featureService.createFeature(feature)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}
