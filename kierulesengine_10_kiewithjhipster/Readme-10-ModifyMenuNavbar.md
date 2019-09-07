# Modify The Application Menu Navigation

##  File: navbar.component.html
##### Path: /kiewithjhipster-02-helloworld/src/main/webapp/app/layouts/navbar/navbar.component.html

``` 
            <!-- jhipster-needle-add-element-to-menu - JHipster will add new menu items here -->
            <li *ngSwitchCase="true" ngbDropdown class="nav-item dropdown pointer" routerLinkActive="active" [routerLinkActiveOptions]="{exact: true}">
            	.
            	.
                        <span>
                            Entities
                        </span>
            	.
            	.
                <ul class="dropdown-menu" ngbDropdownMenu>
                    <li>
                        <!-- ******** -->
                        <!-- ****CHANGE THIS It goes directly to popup: -->
                        <!-- ******** -->
                    	<!--  <a class="dropdown-item" routerLink="message-new" routerLinkActive="active" [routerLinkActiveOptions]="{ exact: true }" (click)="collapseNavbar()"> -->
                        <a class="dropdown-item" [routerLink]="['/', { outlets: { popup: ['message-new'] } }]" routerLinkActive="active" [routerLinkActiveOptions]="{ exact: true }" (click)="collapseNavbar()">
                            <i class="fa fa-fw fa-asterisk" aria-hidden="true"></i>
                            <span>Message</span>
                        </a>
                    </li>
                    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
                </ul>
            </li>

```
